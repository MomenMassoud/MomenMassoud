package supermarket;
public  class TabelData {
    String ID;
    String Name;
    String QTY;
    String Salary;
    String total;
    String cou;
    public TabelData(String cou,String ID, String Name, String QTY, String Salary, String total) {
        this.cou=cou;
        this.ID = ID;
        this.Name = Name;
        this.QTY = QTY;
        this.Salary = Salary;
        this.total = total;
    }

    public void setCou(String cou) {
        this.cou = cou;
    }

    public String getCou() {
        return cou;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getQTY() {
        return QTY;
    }

    public String getSalary() {
        return Salary;
    }

    public String getTotal() {
        return total;
    }

    
}