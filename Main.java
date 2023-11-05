public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Minion> testList = new DoubleLinkedList<>();
        Minion dima = new Minion("Dima", 12);
        Minion artem = new Minion("Artem", 15);
        Minion gena = new Minion("Gena", 15);
        testList.addFirst(dima);
        testList.addLast(artem);
        testList.addLast(gena);
        testList.getAll();
        testList.deleteMinionByName("Artem");
        testList.getAll();
        testList.addLast(dima);
        testList.getAll();
        testList.deleteFirst();
        testList.getAll();
        testList.deleteLast();
        testList.getAll();
        testList.changeMinionAgeByName("Gena",20);
        testList.getAll();
    }
}