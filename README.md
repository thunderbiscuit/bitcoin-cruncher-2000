# Readme

The Bitcoin Cruncher 2000 is a simple command line application that combines 4 libraries written to better understand the structures that together make bitcoin work.

The goal of the application is to put into production 4 hobby libraries that parse and validate the following:
- bitcoin transactions
- bitcoin blocks
- bitcoin scripts
- bitcoin partially signed bitcoin transactions (PSBT)

Those libraries are not released on Maven Central, and so to build this application you will need to build them yourself and publish them to your local Maven repository.

## Build

Build and run using

```shell
just install
cd ./app/build/install/cruncher/bin/
./cruncher --help
```

## Usage

This is an example of the `tx` command on the famous pizza transaction.

```shell
./cruncher tx --hex 01000000018dd4f5fbd5e980fc02f35c6ce145935b11e284605bf599a13c6d415db55d07a1000000008b4830450221009908144ca6539e09512b9295c8a27050d478fbb96f8addbc3d075544dc41328702201aa528be2b907d316d2da068dd9eb1e23243d97e444d59290d2fddf25269ee0e0141042e930f39ba62c6534ee98ed20ca98959d34aa9e057cda01cfd422c6bab3667b76426529382c23f42b9b08d7832d4fee1d6b437a8526e59667ce9c4e9dcebcabbffffffff0200719a81860000001976a914df1bd49a6c9e34dfa8631f2c54cf39986027501b88ac009f0a5362000000434104cd5e9726e6afeae357b1806be25a4c3d3811775835d235417ea746b7db9eeab33cf01674b944c64561ce3388fa1abd0fa88b06c44ce81e2234aa70fe578d455dac00000000
```
Which will output:

```shell
                                             Transaction Data
────────────────┬──────────────────────────────────────────────────────────────────────────────────────────
 Version        │ 1
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 SegWit         │ false
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Num Inputs     │ 1
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Input 0        │
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   Outpoint     │ a1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d:0
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   ScriptSig    │ 4830450221009908144ca6539e09512b9295c8a27050d478fbb96f8addbc3d075544dc41328702201aa528be
                │ 2b907d316d2da068dd9eb1e23243d97e444d59290d2fddf25269ee0e0141042e930f39ba62c6534ee98ed20c
                │ a98959d34aa9e057cda01cfd422c6bab3667b76426529382c23f42b9b08d7832d4fee1d6b437a8526e59667c
                │ e9c4e9dcebcabb
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   Sequence     │ ffffffff
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Num Outputs    │ 2
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Output 0       │
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   Amount       │ 577700000000
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   ScriptPubKey │ 76a914df1bd49a6c9e34dfa8631f2c54cf39986027501b88ac
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Output 1       │
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   Amount       │ 422300000000
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
   ScriptPubKey │ 4104cd5e9726e6afeae357b1806be25a4c3d3811775835d235417ea746b7db9eeab33cf01674b944c64561ce
                │ 3388fa1abd0fa88b06c44ce81e2234aa70fe578d455dac
────────────────┼──────────────────────────────────────────────────────────────────────────────────────────
 Locktime       │ Block-based timelock: 0
────────────────┴──────────────────────────────────────────────────────────────────────────────────────────
```
