public class DoubleLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }
    }
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
    }
    public void deleteFirst() {
        first = first.getNext();
        first.setPrevious(null);
    }
    public void deleteLast() {
        last = last.getPrevious();
        last.setNext(null);
    }
    public void getAll() {
        if (first == null) {
            System.out.println("List is empty.");
            return;
        }
        Node<T> currentNode = first;
        System.out.print("List: ");
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }
    public void deleteAll() {
        first = null;
        last = null;
    }
    public void deleteMinionByName(String name) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData() instanceof Minion) {
                Minion minion = (Minion) currentNode.getData();
                if (minion.getName().equals(name)) {
                    if (currentNode == first && currentNode == last) {
                        first = null;
                        last = null;
                    } else if (currentNode == first) {
                        first = currentNode.getNext();
                        first.setPrevious(null);
                    } else if (currentNode == last) {
                        last = currentNode.getPrevious();
                        last.setNext(null);
                    } else {
                        currentNode.getPrevious().setNext(currentNode.getNext());
                        currentNode.getNext().setPrevious(currentNode.getPrevious());
                    }
                    break;
                }
            }
            currentNode = currentNode.getNext();
        }
    }
    public void changeMinionAgeByName(String name, int age) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData() instanceof Minion) {
                Minion minion = (Minion) currentNode.getData();
                if (minion.getName().equals(name)) {
                    minion.setAge(age);
                    break;
                }
            }
            currentNode = currentNode.getNext();
        }
    }
}