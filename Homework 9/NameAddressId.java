public class NameAddressId extends NameAddress{
    private int id;

    public NameAddressId(){

    }
    public NameAddressId(int id) {
        this.id = id;
    }

    public void set(int id){
        this.id = id;
    }
    public int get(){
        return this.id;
    }

    public NameAddressId clone() {
        return new NameAddressId(this.id);

    }
    public boolean equals(NameAddressId id){
        return (this.id == id.get());
    }


}
