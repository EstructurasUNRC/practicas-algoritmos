/*
 * Copyright (c) 2018 Valentin Cassano.
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

#include <stdio.h>
#include <stdlib.h>
#include "list.h"

/*
 * The header list.h is used in files which need to know of the interface.
 * The main idea is to keep this whole file as a standalone implementation
 * of the interface.
 */

typedef struct linkable_s* linkable_t;

struct linkable_s
{
	int content;
	struct linkable_s *next;
};

/* struct list_s is the realization of list_t (declared in list.h) */

struct list_s
{
	linkable_t head;
	int size;
};

linkable_t create( int element )
{
	linkable_t linkable = ( linkable_t ) malloc ( sizeof( struct linkable_s ) );

	linkable->content = element;
	linkable->next    = NULL;

	return linkable;
}

list_t make( void )
{
	list_t llist = ( list_t ) malloc ( sizeof( struct list_s ) );

	llist->head = NULL;
	llist->size = 0;

	return llist;
}

int is_empty( list_t llist )
{
	return ( llist->size == 0 );
}

int length( list_t llist )
{
	return llist->size;
}

list_t add( list_t llist, int element )
{
	linkable_t linkable = create( element );

	linkable->next = llist->head;
	llist->head = linkable;
	llist->size = (llist->size) + 1;

	return llist;
}

int ins( list_t llist, int element, int position)
{
	if ( position < 0 || position > llist->size )
	{
		return -1;
	};

	if ( !position )
	{
		add( llist, element );
		return 0;
	}

	/* move the cursor to the indicated position */
	linkable_t cursor = llist->head;

	for ( int i = 0; i < position - 1; i++ )
	{
		cursor = cursor->next;
	};

	/* create the new node */
	linkable_t linkable = create( element );

	/* link the two nodes */
	linkable->next = cursor->next;
	cursor->next = linkable;

	/* increase the number of elements in the list */
	llist->size = (llist->size) + 1;

	return 0;
}

list_t end( list_t llist, int element )
{
	ins( llist, element, llist->size );

	return llist;
}

list_t bhd( list_t llist )
{
	if ( is_empty( llist ) )
	{
		return NULL;
	}

	linkable_t cursor = llist->head;
	llist->head = (llist->head)->next;

	// frees the memory that has been allocated using malloc
	free( cursor );

	llist->size = (llist->size) - 1;

	return llist;
}

int at( list_t llist, int position )
{
	linkable_t cursor = llist->head;

	for ( int i = 0; i < position ; i++ )
	{
		cursor = cursor->next;
	};

	return cursor->content;
}

int del( list_t llist, int position)
{
	if ( position < 0 || position > llist->size )
	{
		return -1;
	};

	if ( is_empty( llist ) )
	{
		return -1;
	}

	if ( !position )
	{
		bhd( llist );

		return 0;
	}

	/* move the cursor to the indicated position */
	linkable_t cursor = llist->head;

	for ( int i = 0; i < position - 1; i++ )
	{
		cursor = cursor->next;
	};

	linkable_t linkable = cursor->next;
	cursor->next = (cursor->next)->next;
	// frees the memory that has been allocated using malloc for list node
	free( linkable );

	llist->size = (llist->size) - 1;

	return 0;
}

list_t reverse( list_t llist )
{
	list_t result = make();

	for ( int i = 0; i < llist->size ; i++ )
	{
		add( result, at( llist, i ));
	};

	return result;
}

list_t cat( list_t front, list_t rear )
{
	list_t result = make();

	for ( int i = 0; i < front->size ; i++ )
	{
		end( result, at( front, i ));
	};

	for ( int i = 0; i < rear->size ; i++ )
	{
		end( result, at( rear, i ));
	};

	return result;
}


list_t sub( list_t llist, int s, int e )
{
	list_t result = make();

	for ( int i = s; i < e ; i++ )
	{
		end( result, at( llist, i ));
	};

	return result;
}

list_t cpy( list_t llist )
{
	return sub( llist, 0, llist->size );
}

int hd( list_t llist )
{
	return (llist->head)->content;
}

list_t tl( list_t llist )
{
	return sub( llist, 1, llist->size );
}


void show( list_t llist)
{
	printf( "[ " );

	for ( int i = 0; i < llist->size; i++ )
	{
		printf( "%i ", at( llist, i ) );
	};

	printf( "]" );
}
