## StampedLock
- マルチスレッド環境下でもロックせずに一貫性のある読み取り処理を行う「楽観的読み取り」
- Read Lockの取得コストが不要になる
- Read Lockによって書き込み処理がブロックされることがなくなる
- 読み取り、書き込み双方の高速化が期待できる

## ReentrantReadWriteLock
- 悲観的(pessimistic) Read Lock / Write Lock 操作のみを提供する
- 悲観的ロック操作ではロック獲得要求競合時に優先付けにより、Write/Read操作要求スレッドが飢餓状態に陥る可能性がある
- Java5 -> Read lock優先, Java6 -> Write lock
