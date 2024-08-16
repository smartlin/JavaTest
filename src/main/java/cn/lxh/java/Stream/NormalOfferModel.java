package cn.lxh.java.Stream;

import lombok.Data;

/**
 * Created by starlin
 * on 2024/8/16 15:32.
 */
@Data
public class NormalOfferModel {
    private String cate1LevelId;

    public NormalOfferModel(String cate1LevelId) {
        this.cate1LevelId = cate1LevelId;
    }
}
