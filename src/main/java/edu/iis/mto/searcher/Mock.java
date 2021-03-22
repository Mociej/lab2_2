package edu.iis.mto.searcher;

public class Mock implements SequenceSearcher{
    public int count=0;
    @Override
    public SearchResult search(int elem, int[] sequence) {
        if(sequence==null){
            throw new IllegalArgumentException();
        }
        count++;

        SearchResult.Builder builder=SearchResult.builder();

        for(int i=0;i<sequence.length;i++){
            if(sequence[i]==elem){
                builder.withPosition(i);
                builder.withFound(true);
                break;
            }
        }

        return builder.build();
    }
}
