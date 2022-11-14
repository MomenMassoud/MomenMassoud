package hotel_soft4u;

public class Room {
    private int Number_room;
    private int Size;
    private int empty;
    private Double salary;

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setNumber_room(int Number_room) {
        this.Number_room = Number_room;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public void setEmpty(int empty) {
        this.empty = empty;
    }

    public int getNumber_room() {
        return Number_room;
    }

    public int getSize() {
        return Size;
    }

    public int getEmpty() {
        return empty;
    }

    public Room() {
    }
}
