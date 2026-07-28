package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {

    private final HashSet<Searchable> searchables = new HashSet<>();

    public SearchEngine(int size) {
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public TreeSet<Searchable> search(String searchTerm) {

        if (searchTerm == null || searchTerm.isBlank()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }

        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(searchTerm))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(new SearchableComparator())
                ));
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