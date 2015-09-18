/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mars.utils.json.model;

/**
 *
 * @author AG BRIGHTER
 */
public class ArrayHolder<E>
{
    private E[] elements;

    public ArrayHolder() {
    }

    public void setElements(E[] elements) {
        this.elements = elements;
    }

    public E[] getElements() {
        return elements;
    }
    
    
}
