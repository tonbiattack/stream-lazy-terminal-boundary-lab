# Java Streamの遅延評価は終端操作まで実行されない境界を実際にデバッグする

Streamの中間操作はパイプラインを組み立てるだけでは実行されず、終端操作が始まったときに評価される。修正前テストはfilterの副作用が組み立て時に起きると誤解し、修正後は終端操作の有無を明示的に検証する。

## 実行

修正前の失敗状態:

```bash
git checkout <bug-commit>
mvn test
```

修正後の確認:

```bash
git checkout <fix-commit>
mvn clean test
```

対象サービスは `src/main/java`、利用者視点のテストは `src/test/java`、実行証拠は `evidence/` にあります。
