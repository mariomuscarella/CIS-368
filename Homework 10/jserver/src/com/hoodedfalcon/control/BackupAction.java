/** CIS 368 QUARTER 4 GROUP 2
 * MEMBERS:
 * GLEN FANNIN
 * JOHN LIGGETT
 * MARIO MUSCARELLA
 * CHRISTINA VECCHIO
 */

package com.hoodedfalcon.control;

import com.hoodedfalcon.model.MyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.*;

public class BackupAction
{
	private MyFile myFile;
	private File file;

	private void setFile(File file)
	{
		this.file = file;
	}

	public void setMyFile(MyFile myFile)
	{
		this.myFile = myFile;
		this.setFile(myFile.getFile());
	}

	public void backup()
	{
		if (file == null) return;
		synchronized (myFile.getLock())
		{
			if (!myFile.getFile().equals(file)) setFile(myFile.getFile());

			try
			{
				File zipFile = new File(file.getParent(), file.getName() + "-backup.zip");

				FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(zipFile);
				ZipOutputStream zos = new ZipOutputStream(fos);

				ZipEntry entry = new ZipEntry(file.getName());
				zos.putNextEntry(entry);

				byte[] buffer = new byte[2048];
				int bytes;

				while (true)
				{
					bytes = fis.read(buffer);
					if (bytes == -1) break;
					zos.write(buffer, 0, bytes);
				}

				fis.close();
				zos.closeEntry();
				zos.close();
				fos.close();
			}
			catch(Throwable t)
			{
				t.printStackTrace();
			}
		}
	}
}

