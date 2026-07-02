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
}