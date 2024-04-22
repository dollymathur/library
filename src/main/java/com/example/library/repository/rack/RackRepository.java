package com.example.library.repository.rack;

import com.example.library.model.Book;
import com.example.library.model.BookCopy;
import com.example.library.model.Rack;
import com.example.library.model.Slot;

public class RackRepository {

    RackInventory rackInventory = new RackInventory();

    public void addRack(Rack rack) {
        rackInventory.racks.add(rack);
        System.out.println("Rack with rackId: " + rack.getId() + " added successfully");
    }

    public void showRacks() {
        for (Rack rack : rackInventory.racks) {
            System.out.println(rack);
        }
    }

    public void addBookInRack(BookCopy bookCopy) {
        for (Rack rack : rackInventory.racks) {
            boolean found = false;
            if (rack.getAvailableSlots() != 0) {
                for (int i = 0; i < rack.getSlots().size(); i++) {
                    if (rack.getSlots().get(i).getBookId() == bookCopy.getBookId()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    rack.getSlots().add(new Slot(bookCopy.getBookId(), bookCopy.getCopyId()));
                    rack.setAvailableSlots(rack.getAvailableSlots() - 1);
                    System.out.println("Book with bookId: " + bookCopy.getBookId() + " copyId: " + bookCopy.getBookId() + " added successfully in rackId: " + rack.getId());
                    break;
                }
            }
        }
    }

    public void removeBookFromRack(BookCopy bookCopy) {
        for (Rack rack : rackInventory.racks) {
            for (int i = 0; i < rack.getSlots().size(); i++) {
                if (rack.getSlots().get(i).getBookId() == bookCopy.getBookId() && rack.getSlots().get(i).getCopyId() == bookCopy.getCopyId()) {
                    rack.getSlots().remove(i);
                    rack.setAvailableSlots(rack.getAvailableSlots() + 1);
                    break;
                }
            }
        }
    }
}
