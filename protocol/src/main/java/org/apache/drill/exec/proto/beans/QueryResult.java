/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from protobuf

package org.apache.drill.exec.proto.beans;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.Schema;

public final class QueryResult implements Externalizable, Message<QueryResult>, Schema<QueryResult>
{
    public enum QueryState implements com.dyuproject.protostuff.EnumLite<QueryState>
    {
        STARTING(0),
        RUNNING(1),
        COMPLETED(2),
        CANCELED(3),
        FAILED(4),
        CANCELLATION_REQUESTED(5),
        ENQUEUED(6);
        
        public final int number;
        
        private QueryState (int number)
        {
            this.number = number;
        }
        
        public int getNumber()
        {
            return number;
        }
        
        public static QueryState valueOf(int number)
        {
            switch(number) 
            {
                case 0: return STARTING;
                case 1: return RUNNING;
                case 2: return COMPLETED;
                case 3: return CANCELED;
                case 4: return FAILED;
                case 5: return CANCELLATION_REQUESTED;
                case 6: return ENQUEUED;
                default: return null;
            }
        }
    }


    public static Schema<QueryResult> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static QueryResult getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final QueryResult DEFAULT_INSTANCE = new QueryResult();

    
    private QueryState queryState;
    private QueryId queryId;
    private List<DrillPBError> error;

    public QueryResult()
    {
        
    }

    // getters and setters

    // queryState

    public QueryState getQueryState()
    {
        return queryState == null ? QueryState.STARTING : queryState;
    }

    public QueryResult setQueryState(QueryState queryState)
    {
        this.queryState = queryState;
        return this;
    }

    // queryId

    public QueryId getQueryId()
    {
        return queryId;
    }

    public QueryResult setQueryId(QueryId queryId)
    {
        this.queryId = queryId;
        return this;
    }

    // error

    public List<DrillPBError> getErrorList()
    {
        return error;
    }

    public QueryResult setErrorList(List<DrillPBError> error)
    {
        this.error = error;
        return this;
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<QueryResult> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public QueryResult newMessage()
    {
        return new QueryResult();
    }

    public Class<QueryResult> typeClass()
    {
        return QueryResult.class;
    }

    public String messageName()
    {
        return QueryResult.class.getSimpleName();
    }

    public String messageFullName()
    {
        return QueryResult.class.getName();
    }

    public boolean isInitialized(QueryResult message)
    {
        return true;
    }

    public void mergeFrom(Input input, QueryResult message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.queryState = QueryState.valueOf(input.readEnum());
                    break;
                case 2:
                    message.queryId = input.mergeObject(message.queryId, QueryId.getSchema());
                    break;

                case 3:
                    if(message.error == null)
                        message.error = new ArrayList<DrillPBError>();
                    message.error.add(input.mergeObject(null, DrillPBError.getSchema()));
                    break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, QueryResult message) throws IOException
    {
        if(message.queryState != null)
             output.writeEnum(1, message.queryState.number, false);

        if(message.queryId != null)
             output.writeObject(2, message.queryId, QueryId.getSchema(), false);


        if(message.error != null)
        {
            for(DrillPBError error : message.error)
            {
                if(error != null)
                    output.writeObject(3, error, DrillPBError.getSchema(), true);
            }
        }

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
            case 1: return "queryState";
            case 2: return "queryId";
            case 3: return "error";
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
        __fieldMap.put("queryState", 1);
        __fieldMap.put("queryId", 2);
        __fieldMap.put("error", 3);
    }
    
}
