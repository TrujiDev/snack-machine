package service;

import data.SnackData;
import model.Snack;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class SnackService {
    private List<Snack> snacks;

    public SnackService() throws IOException {
        snacks = SnackData.loadSnacks();
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public Optional<Snack> getSnackById(int id) {
        return snacks.stream().filter(snack -> snack.getIdSnack() == id).findFirst();
    }

    public void addSnack(Snack snack) throws IOException {
        snacks.add(snack);
        SnackData.saveSnacks(snacks);
    }
}
