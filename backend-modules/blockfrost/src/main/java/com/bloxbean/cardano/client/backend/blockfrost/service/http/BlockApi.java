package com.bloxbean.cardano.client.backend.blockfrost.service.http;

import java.math.BigInteger;

import com.bloxbean.cardano.client.backend.model.Block;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BlockApi {

    @GET("blocks/latest")
    Call<Block> getLatestBlock(@Header("project_id") String projectId);

    @GET("blocks/{hash}")
    Call<Block> getBlockByHash(@Header("project_id") String projectId, @Path("hash") String hash);

    @GET("blocks/{number}")
    Call<Block> getBlockByNumber(@Header("project_id") String projectId, @Path("number") BigInteger number);

    @GET("blocks/{number}/txs")
    Call<String[]> getTransactionHashesByBlockNumber(@Header("project_id") String projectId, @Path("number") BigInteger number, @Query("count") Integer count, @Query("page") Integer page, @Query("order") String order);

    @GET("blocks/{hash}/txs")
    Call<String[]> getTransactionHashesByBlockHash(@Header("project_id") String projectId, @Path("hash") String hash, @Query("count") Integer count, @Query("page") Integer page, @Query("order") String order);
}
