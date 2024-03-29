package algorithms.search;

import java.io.Serializable;
import java.util.*;

/**
 * abstract class  of searching algorithms
 * all  algorithms find the solution path with " TheShortestPath()"
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm , Serializable {
    protected Queue<AState> VQ;
    protected int counter;

    public ASearchingAlgorithm() {
        this.counter = 0;
    }

    protected void TheShortestPath(ISearchable p, Solution S, AState curr) {
        if (curr==p.getStart()) {
            S.setSol(p.getStart());
        }
        else {
            if (curr.getParent()!=null){
                S.setSol(curr);
                TheShortestPath(p,S,curr.getParent());}
        }
        }


    }

