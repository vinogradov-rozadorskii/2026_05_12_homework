package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable first, Searchable second) {

        int result = Integer.compare(
                second.getName().length(),
                first.getName().length()
        );

        if (result == 0) {
            result = first.getName().compareTo(second.getName());
        }

        return result;
    }
}