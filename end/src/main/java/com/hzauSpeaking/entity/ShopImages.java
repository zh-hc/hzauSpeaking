package com.hzauSpeaking.entity;

import javax.persistence.*;

@Table(name = "`shop_images`")
public class ShopImages {
    @Id
    @Column(name = "`shop_detail_id`")
    private Integer shopDetailId;

    @Column(name = "`shop_id`")
    private Integer shopId;

    @Column(name = "`shop_images`")
    private String shopImages;

    /**
     * @return shop_detail_id
     */
    public Integer getShopDetailId() {
        return shopDetailId;
    }

    /**
     * @param shopDetailId
     */
    public void setShopDetailId(Integer shopDetailId) {
        this.shopDetailId = shopDetailId;
    }

    /**
     * @return shop_id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * @return shop_images
     */
    public String getShopImages() {
        return shopImages;
    }

    /**
     * @param shopImages
     */
    public void setShopImages(String shopImages) {
        this.shopImages = shopImages;
    }
}