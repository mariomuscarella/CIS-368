public class NameAddress extends FullName {
    private FullName fullName = new FullName(this.getFirst(),this.getMiddle(),this.getLast());
    private Address address = new Address(this.getStreet(),this.getCity(),this.getState(),this.getZip());
    public NameAddress(){

    }
    public NameAddress(FullName fullName,Address address){
        this.fullName = fullName;
        this.address = address;
    }

    public NameAddress clone() {
        return new NameAddress(this.fullName,this.address);
    }
    public boolean equals(NameAddress nameAddress){

        if(nameAddress.equals(this.address) && nameAddress.equals(this.fullName)){
            return true;
        }
        else
        return false;
    }
}
