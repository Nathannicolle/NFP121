package domain;

public class List<ElementType> {
    private class ListElement {
        public ElementType content;
        public ListElement next;
        public ListElement previous;

        public ListElement(ElementType element) {
            content = element;
            next = previous = null;
        }
    }

    private  ListElement first, last;
    private int numberOfElements;

    public List() {
        first = last = null;
        numberOfElements = 0;
    }

    public void add(ElementType element) {
        ListElement newListElement = new ListElement(element);
        if(first == null ) {
            first = last = newListElement;
        } else {
            last.next = newListElement;
            newListElement.previous = last;
        }
    }

    public void remove(ElementType element) {
    }

    public void remove(int index) {
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
