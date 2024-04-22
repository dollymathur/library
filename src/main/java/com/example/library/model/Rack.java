package com.example.library.model;

import java.util.List;

public class Rack {
    int id;
    int size;
    List<Slot> slots;
    int availableSlots;

    public Rack(int id, int size, List<Slot> slots) {
        this.id = id;
        this.size = size;
        this.slots = slots;
        this.availableSlots = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    @Override
    public String toString() {
        return "Rack{" +
                "id=" + id +
                ", size=" + size +
                ", slots=" + slots +
                ", availableSlots=" + availableSlots +
                '}';
    }
}
