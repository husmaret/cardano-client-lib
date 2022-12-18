package com.bloxbean.cardano.client.backend.api;

import com.bloxbean.cardano.client.api.exception.ApiException;
import com.bloxbean.cardano.client.backend.model.Block;
import com.bloxbean.cardano.client.api.model.Result;

import java.math.BigInteger;

public interface BlockService {

    /**
     * Get the Latest Block
     *
     * @return Get latest block
     */
    Result<Block> getLatestBlock() throws ApiException;

    /**
     * Get Block by Block Hash
     *
     * @param blockHash
     * @return Get block details by block hash
     */
    Result<Block> getBlockByHash(String blockHash) throws ApiException;

    /**
     * Get Block by Block Number
     *
     * @param blockNumber
     * @return Get block by block number
     */
    Result<Block> getBlockByNumber(BigInteger blockNumber) throws ApiException;

    /**
     * Get Transaction Hashes by Block Hash
     *
     * @param blockHash
     * @param count The number of results displayed on one page - Default: 100
     * @param page The page number for listing the results - Default: 1
     * @param order Enum "asc" or "desc" - Default: "asc"
     * @return Get Transaction hashes by block hash
     */
    Result<String[]> getTransactionHashesByBlockHash(String blockHash, Integer count, Integer page, String order) throws ApiException;
    
    /**
     * Get Transaction Hashes by Block Number
     *
     * @param blockNumber
     * @param count The number of results displayed on one page - Default: 100
     * @param page The page number for listing the results - Default: 1
     * @param order Enum "asc" or "desc" - Default: "asc"
     * @return Get Transaction hashes by block number
     */
    Result<String[]> getTransactionHashesByBlockNumber(BigInteger blockNumber, Integer count, Integer page, String order) throws ApiException;

}
