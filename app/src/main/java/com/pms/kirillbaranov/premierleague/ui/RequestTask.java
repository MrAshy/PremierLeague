package com.pms.kirillbaranov.premierleague.ui;

import android.os.AsyncTask;

/**
 * Created by KirillBaranov on 08.12.16.
 */

public abstract class RequestTask<Result> implements Runnable {
    private IProgressBehavior mProgressBehavior;

    private Runnable mExecuteTaskRunnable = new Runnable() {
        @Override
        public void run() {
            new AsyncTask<Void, Void, Result>() {
                private Exception mException;
                @Override
                protected void onPreExecute() {
                    showLoadingDialog();
                }

                @Override
                protected Result doInBackground(Void... params) {
                    try {
                        return RequestTask.this.doInBackground(params);

                    } catch (Exception e) {
                        mException = e;

                    }
                    return null;
                }

                @Override
                protected void onPostExecute(final Result result) {
                    hideDialogAndDoOnPostExecute(result, mException);
                };

                private void showLoadingDialog() {
                    mProgressBehavior.startTask();
                }

                private void hideDialogAndDoOnPostExecute(Result result, Exception exception) {
                    mProgressBehavior.endTask();
                    RequestTask.this.onPostExecute(result, exception);

                }

            }.execute();
        }
    };



    public interface IProgressBehavior {
        void startTask();
        void endTask();
    }

    public RequestTask(IProgressBehavior progressBehavior) {
        mProgressBehavior = progressBehavior;
    }

    @Override
    public void run() {
        mExecuteTaskRunnable.run();
    }

    protected abstract Result doInBackground(Void... params) throws Exception;

    /** runs on UI when no Exceptio happen in onDoInBackground()*/
    protected abstract void onSuccess(Result result);

    protected void onPostExecute(Result result, Exception e) {
        if(e != null) onError(e);
        else onSuccess(result);
    }

    /** runs on UI*/
    protected void onError(Exception exception) {

    }
}
