/* 
 * Copyright (c) 2019 Pablo Ameri.
 * Ayudante de 2da: Estructuras de Datos y Algoritmos/Algoritmos I.
 * Universidad Nacional de Rio Cuarto, Argentina.
 * 
 * This program is free software: you can redistribute it and/or modify  
 * it under the terms of the GNU General Public License as published by  
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License 
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

#ifndef LIST_H
#define LIST_H

// object of an incomplete type
typedef struct list_s* list_t;

// returns an empty list
list_t make( void );

// is the list empty?
int is_empty( list_t list );

// adds an element at the beginning of the list
list_t add( list_t list, int element );


// adds an element at the end of the list
list_t end( list_t list, int element );

// inserts an element in a particular position in the list
/*  0 if successful              
 * -1 if the position is invalid */
int ins( list_t list, int element, int position);

// returns the element at the indicated position
/* the position must be valid */
int at( list_t list, int position );

// removes the head of the list (deletes its first element)
/*  0 if successful
 * -1 if the list is empty */
list_t bhd( list_t list );

// deletes an element in a particular position in the list
/*  0 if successful
 * -1 if the position is invalid or the list is empty */
int del( list_t list, int position);

// the reverse of a list
list_t reverse( list_t list );

// the sub-list starting at 'from' and ending at 'to'
list_t sub( list_t list, int from, int to );

// a copy of the list
list_t cpy( list_t list );

// the concatenation of the lists
list_t cat( list_t front, list_t rear );

// the first element of a non-empty list
int hd( list_t list );

// all but the first element of a list
list_t tl( list_t list );

// displays the content of the list on the std output
void show( list_t list );


#endif
