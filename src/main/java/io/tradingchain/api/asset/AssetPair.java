package io.tradingchain.api.asset;

public class AssetPair {
  public String assetName;
  public String assetIssuer;

  public AssetPair(String assetName, String assetIssuer) {
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
  }

  public AssetPair setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public AssetPair setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }
}
