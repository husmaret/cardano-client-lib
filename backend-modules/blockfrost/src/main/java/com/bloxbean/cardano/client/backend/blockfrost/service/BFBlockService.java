package com.bloxbean.cardano.client.backend.blockfrost.service;

import com.bloxbean.cardano.client.backend.api.BlockService;
import com.bloxbean.cardano.client.api.exception.ApiException;
import com.bloxbean.cardano.client.backend.blockfrost.service.http.BlockApi;
import com.bloxbean.cardano.client.backend.model.Block;
import com.bloxbean.cardano.client.api.model.Result;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigInteger;

public class BFBlockService extends BFBaseService implements BlockService  {

    private BlockApi blockApi;

    public BFBlockService(String baseUrl, String projectId) {
        super(baseUrl, projectId);
        this.blockApi = getRetrofit().create(BlockApi.class);
    }


    @Override
    public Result<Block> getLatestBlock() throws ApiException {
        Call<Block> blockCall = blockApi.getLatestBlock(getProjectId());

        try {
            Response<Block> response = blockCall.execute();
            if(response.isSuccessful())
                return Result.success(response.toString()).withValue(response.body()).code(response.code());
            else
                return Result.error(response.errorBody().string()).code(response.code());

        } catch (IOException e) {
            throw new ApiException("Error getting latest block", e);
        }
    }

    @Override
    public Result<Block> getBlockByHash(String blockHash) throws ApiException {
        Call<Block> blockCall = blockApi.getBlockByHash(getProjectId(), blockHash);

        try {
            Response<Block> response = blockCall.execute();
            if(response.isSuccessful())
                return Result.success(response.toString()).withValue(response.body()).code(response.code());
            else
                return Result.error(response.errorBody().string()).code(response.code());

        } catch (IOException e) {
            throw new ApiException("Error getting block by hash", e);
        }
    }

    @Override
    public Result<Block> getBlockByNumber(BigInteger blockNumber) throws ApiException {
        Call<Block> blockCall = blockApi.getBlockByNumber(getProjectId(), blockNumber);

        try {
            Response<Block> response = blockCall.execute();
            if(response.isSuccessful())
                return Result.success(response.toString()).withValue(response.body()).code(response.code());
            else
                return Result.error(response.errorBody().string()).code(response.code());

        } catch (IOException e) {
            throw new ApiException("Error getting block by number", e);
        }
    }

    @Override
    public Result<String[]> getTransactionHashesByBlockHash(String blockHash, Integer count, Integer page, String order) throws ApiException {
        Call<String[]> blockCall = blockApi.getTransactionHashesByBlockHash(getProjectId(), blockHash, count, page, order);

        try {
            Response<String[]> response = blockCall.execute();
            if(response.isSuccessful()) {
                return Result.success(response.toString()).withValue(response.body()).code(response.code());
            } else {
                return Result.error(response.errorBody().string()).code(response.code());
            }
        } catch (IOException e) {
            throw new ApiException("Error getting block by hash", e);
        }
    }

    @Override
    public Result<String[]> getTransactionHashesByBlockNumber(BigInteger blockNumber, Integer count, Integer page, String order) throws ApiException {
        Call<String[]> blockCall = blockApi.getTransactionHashesByBlockNumber(getProjectId(), blockNumber, count, page, order);

        try {
            Response<String[]> response = blockCall.execute();
            if(response.isSuccessful()){
                return Result.success(response.toString()).withValue(response.body()).code(response.code());
            } else {
                return Result.error(response.errorBody().string()).code(response.code());
            }
        } catch (IOException e) {
            throw new ApiException("Error getting block by number", e);
        }
    }


}
