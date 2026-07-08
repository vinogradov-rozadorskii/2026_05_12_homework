package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }

    public Searchable[] search(String searchTerm) {

        if (searchTerm == null || searchTerm.isBlank()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }

        Searchable[] result = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null &&
                    searchable.getSearchTerm().contains(searchTerm)) {

                result[count] = searchable;
                count++;

                if (count == 5) {
                    break;
                }
            }
        }

        return result;
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        Searchable best = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

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