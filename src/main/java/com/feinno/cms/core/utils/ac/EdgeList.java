package com.feinno.cms.core.utils.ac;

/**
   Simple interface for mapping bytes to States.
 */
interface EdgeList {
    State get(byte ch);
    void put(byte ch, State state);
    byte[] keys();
}
