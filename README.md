<div align="center">

# 💩 SuperUnko.clj

Clojureで書かれた[unkontributors/super_unko](https://github.com/unkontributors/super_unko)

<br>
<br>
</div>

## 🔨 使い方

> [!IMPORTANT]
> Windowsで使用する際は、`chcp 65001`を実行するなどして、ターミナルの文字コードをUTF-8にしてください

```bash
lein run -m superunko.clj 5
```
```
　　　　　👑
　　　　💩💩💩
　　　💩👁💩👁💩
　　💩💩💩👃💩💩💩
　💩💩💩💩👄💩💩💩💩
```

```bash
lein run -m superunko.clj 10
```

```
　　　　　　　　　　👑
　　　　　　　　　💩💩💩
　　　　　　　　💩👁💩👁💩
　　　　　　　💩💩💩👃💩💩💩
　　　　　　💩💩💩💩👄💩💩💩💩
　　　　　💩💩💩💩💩💩💩💩💩💩💩
　　　　💩💩💩💩💩💩💩💩💩💩💩💩💩
　　　💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩
　　💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩
　💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩💩
```

### 並列化
`-p`,`--parallel`オプションで並列処理を行います。    
高速でSuperUnkoを生成できます。
```bash
lein run -m superunko.clj -p 5
```
#### ベンチマーク
```bash
>lein run -m superunko.clj/parallel-benchmark
Non-parallel: "Elapsed time: 3989.6943 msecs"

Parallel: "Elapsed time: 1468.002301 msecs"
```



### 組体操オプション
`-k`,`--kumitaisou`オプションで組体操になります。    
Unkoが苦手はこちらをどうぞ。
```bash
lein run -m superunko.clj -k 5
```

```
　　　　　👑
　　　　🙇🙇🙇
　　　🙇🙇🙇🙇🙇
　　🙇🙇🙇🙇🙇🙇🙇
　🙇🙇🙇🙇🙇🙇🙇🙇🙇
```

### テスト
```bash
lein test
```

## 🎫 LICENSE

[MIT](./LICENSE)

## ✍ Author

[PenguinCabinet](https://github.com/PenguinCabinet)
