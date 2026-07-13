# Geospatial Audio AR

現実の緯度経度に音源を配置し、**スマホのカメラを向けた方向の音が大きく聞こえる**音声ARアプリです。
ARCore Geospatial API(VPS)による自己位置推定を利用しています。

## 仕組み

- 緯度・経度で指定した地点にアンカーを解決し、ループ音声を紐付け
- カメラの前方ベクトルと音源方向のなす角(内積)で音量を減衰(正面ほど大きい)
- アンカーまでの実距離に応じて音量とこもり(高音域カット)を変化

実装の中心は `GeospatialActivity#updateSpatialAudio()` です。

## 動作要件

- ARCore 対応の Android 端末(API 24 以上)
- VPS 対応エリア(ストリートビューが整備された屋外)での利用
- ARCore Geospatial API の利用設定([手順](https://developers.google.com/ar/develop/java/geospatial/enable))

音源の配置地点は `GeospatialActivity` の `onCreate` 内で登録します。

## クレジット

音声合成には VOICEVOX を使用しています。

- VOICEVOX: ずんだもん / 青山龍星 / 冥鳴ひまり / ちび式じい / 春日部つむぎ

## ライセンス

[Apache License 2.0](LICENSE)

本プロジェクトは Google の [ARCore Geospatial Java サンプル](https://github.com/google-ar/arcore-android-sdk)(Apache License 2.0)をベースに、空間オーディオ機能を追加・改変したものです。
