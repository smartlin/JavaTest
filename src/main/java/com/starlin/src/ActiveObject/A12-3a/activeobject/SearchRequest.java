package com.starlin.src.ActiveObject.A12;

class SearchRequest extends MethodRequest<String> {
    private final String word;
    public SearchRequest(Servant servant, FutureResult<String> future, String word) {
        super(servant, future);
        this.word = word;
    }
    public void execute() {
        Result<String> result = servant.search(word);
        future.setResult(result);
    }
}
