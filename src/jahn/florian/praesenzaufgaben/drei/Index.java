package jahn.florian.praesenzaufgaben.drei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Index {

    private TreeMap<String, ArrayList<Integer>> index;

    public Index() {

        this.index = new TreeMap<>();
    }

    public void wortHinzufuegen(String term, int page) {

        if (this.index.get(term) == null) {

            ArrayList<Integer> x = new ArrayList<>();
            x.add(page);

            this.index.put(term, x);
        } else if (!this.index.get(term).contains(page)) {

            this.index.get(term).add(page);
            Collections.sort(this.index.get(term));
        }
    }

    public ArrayList<Integer> getAlleFundstellen(String wort) {

        ArrayList<Integer> out = new ArrayList<>();

        if (this.index.get(wort) != null) {

            out.addAll(this.index.get(wort));
        }

        return out;
    }

    public int getErsteFundstelle(String wort) {

        if (this.index.get(wort) == null) {

            return -1;
        }

        Collections.sort(this.index.get(wort));

        return this.index.get(wort).get(0);
    }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();

        for (String x : this.index.keySet()) {

            out.append(x).append(": ");

            ArrayList<Integer> z = this.index.get(x);

            out.append("[");

            for (int i = 0; i < z.size(); i++) {

                out.append(z.get(i));

                if (i != z.size() - 1) {

                    out.append(", ");
                }
            }

            out.append("]\n");
        }

        return out.toString();
    }

}