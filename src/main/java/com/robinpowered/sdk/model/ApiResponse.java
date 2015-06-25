package com.robinpowered.sdk.model;

import java.util.List;
import java.util.Map;

/**
 * A full API response object.
 *
 * @param <DataType> The model class that is contained within the result's data.
 */
public class ApiResponse<DataType> {

    /**
     * Properties
     */

    private Meta meta;
    private DataType data;
    private Object paging;


    /**
     * Methods
     */

    public Meta getMeta() {
        return meta;
    }

    public DataType getData() {
        return data;
    }

    public Object getPaging() {
        return paging;
    }

    @Override
    public String toString() {
        return "Result{" +
                "meta=" + meta +
                ", data=" + data +
                ", paging=" + paging +
                '}';
    }

    /**
     * The meta information about the result.
     */
    public class Meta {

        /**
         * Properties
         */

        private Integer statusCode;
        private String status;
        private String message;
        private Map<String, List<String>> moreInfo;


        /**
         * Methods
         */

        public Integer getStatusCode() {
            return statusCode;
        }

        public String getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public Map<String, List<String>> getMoreInfo() {
            return moreInfo;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "status_code=" + statusCode +
                    ", status='" + status + '\'' +
                    ", message='" + message + '\'' +
                    ", more_info=" + moreInfo +
                    '}';
        }
    }
}
