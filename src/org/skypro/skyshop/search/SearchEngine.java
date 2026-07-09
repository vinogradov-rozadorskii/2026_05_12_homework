package org.skypro.skyshop.search;

import java.util.LinkedList;

public class SearchEngine {

    private final LinkedList<Searchable> searchables = new LinkedList<>();

    public SearchEngine(int size) {
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable[] search(String searchTerm) {

        if (searchTerm == null || searchTerm.isBlank()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }

        LinkedList<Searchable> result = new LinkedList<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                result.add(searchable);
            }
        }

        return result.toArray(new Searchable[0]);
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {

            String text = searchable.getSearchTerm();
            int count = 0;
            int index = 0;

            while ((index = text.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }

            if (count > maxCount) {
                maxCount = count;
                best = searchable;
            }
        }

        if (best == null) {
            throw new BestResultNotFound("По запросу \"" + search + "\" ничего не найдено");
        }

        return best;
    }
}