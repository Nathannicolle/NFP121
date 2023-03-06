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

        numberOfElements++;
    }

    public void remove(ElementType element) {
    }

    public void remove(int index) {
    }

    public int size() {
        return numberOfElements;
    }

    private ElementType getFromBeginning(int index) {
        ListElement current = first;
        while (current != null && index > 0) {
            current = current.next;
            index--;
        }

        return current.content;
    }

    private ElementType getFromEnd(int index) {
        ListElement current = last;
        while (current != null && index > 0) {
            current = current.previous;
            index--;
        }

        return current.content;
    }

    public ElementType get(int index) {
        if(index < size() / 2) {
            return getFromBeginning(index);
        }

        return  getFromEnd(index - 1);
    }

    public boolean isEmpty() {
        return first == null;
    }
}
