/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.MyFile;
import com.hoodedfalcon.model.MyList;
import com.hoodedfalcon.model.nameaddress.NameAddressId;

import java.io.*;
import java.util.Scanner;

public class UpdateAction
{
	private MyFile myFile;
	private MyList<NameAddressId> recordsList;
	private MyList<Integer> deletedRecords;
	private MyList<Integer> editedRecords;

	private MyList<NameAddressId> recordsCopy = new MyList<>();
	private MyList<Integer> deletedCopy = new MyList<>();

	private MyList<Integer> recordsToUpdate = new MyList<>();

	/**
	 * Entry point of the UpdateAction object.
	 */
	public void update()
	{
		synchronized (recordsList.getLock())
		{
			synchronized (deletedRecords.getLock())
			{
				if ((recordsList == null || recordsList.getList() == null || recordsList.getList().size() == 0) &&
						(deletedRecords == null || deletedRecords.getList() == null || deletedRecords.getList().size() == 0))
				{
					return;
				}

				for (int i = 0; i < recordsList.getList().size(); i++)
				{
					recordsCopy.getList().add((NameAddressId)recordsList.getList().get(i).clone());
					recordsToUpdate.getList().add(recordsList.getList().get(i).getID());

					if (deletedRecords.getList().contains(Integer.valueOf(recordsList.getList().get(i).getID())))
					{
						deletedRecords.getList().remove(Integer.valueOf(recordsList.getList().get(i).getID()));
					}
				}

				for (int i = 0; i < deletedRecords.getList().size(); i++)
				{
					deletedCopy.getList().add(deletedRecords.getList().get(i));
				}

				recordsList.getList().clear();
				deletedRecords.getList().clear();

				synchronized (editedRecords.getLock())
				{
					editedRecords.getList().clear();
				}
			}
		}

		if (myFile == null) return;
		if (myFile.getFile() == null) return;

		synchronized (myFile.getLock())
		{
			createTempFile();
			replaceFile();
		}

		recordsCopy.getList().clear();
		deletedCopy.getList().clear();
		recordsToUpdate.getList().clear();
	}


	/**
	 * Updates the file
	 */
	private void createTempFile()
	{
		try
		{
			File tempFile = new File("tempfile.csv");
			Scanner fileIn = new Scanner(myFile.getFile());
			String line;
			FileWriter fileWriter = new FileWriter(tempFile);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			fileIn.nextLine(); // Skip the Header Line
			writer.write("ID,Zip Code,First Name,Middle Name,Last Name,Street,City,State"); // Writer Header Line

			while (fileIn.hasNextLine())
			{
				String[] words = fileIn.nextLine().split(",");
				if (words.length == 0) break;

				line = mergeArray(words);

				if (deletedCopy.getList().contains(Integer.valueOf(words[0]))
						|| recordsToUpdate.getList().contains(Integer.valueOf(words[0])))
				{
					continue;
				}

				writer.newLine();
				writer.write(line);
			}

			for (int i = 0; i < recordsCopy.getList().size(); i++)
			{
				writer.newLine();
				line = recordToString(recordsCopy.getList().get(i));
				writer.write(line);
			}

			writer.close();
			fileWriter.close();
			fileIn.close();
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}

	private void replaceFile()
	{
		try
		{
			File tempFile = new File("tempfile.csv");
			Scanner fileIn = new Scanner(tempFile);
			String line;

			FileWriter fileWriter = new FileWriter(myFile.getFile(), false);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			line = fileIn.nextLine();
			writer.write(line);

			while (fileIn.hasNextLine())
			{
				writer.newLine();
				line = fileIn.nextLine();
				writer.write(line);
			}

			writer.close();
			fileWriter.close();

			fileIn.close();

			boolean outcomeSuccess = tempFile.delete();
			if (!outcomeSuccess) System.out.println("File could not be deleted!");
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
	}

	private String mergeArray(String[] array)
	{
		String value = array[0];
		for (int i = 1; i < array.length; i++)
		{
			value += ",";
			value += array[i];
		}
		return value;
	}

	public void setMyFile(MyFile myFile)
	{
		this.myFile = myFile;
	}

	public void setChanges(MyList<NameAddressId> recordsList, MyList<Integer> deletedRecords, MyList<Integer> editedRecords)
	{
		this.recordsList = recordsList;
		this.deletedRecords = deletedRecords;
		this.editedRecords = editedRecords;
	}

	private String recordToString(NameAddressId record)
	{
		return record.getID() + "," + record.getZip() + "," + record.getFirst().get() + "," + record.getMiddle().get() +
				"," + record.getLast().get() + "," + record.getStreet() + "," + record.getCity().get() + "," +
				record.getState().get();
	}


}
