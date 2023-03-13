## Visitor Patterns and Traversals

### Preorder traversal

```
Algorithm preorder(T,v):
	perform the "visit" action for node v
	if v has a left child u in T then
		preorder(T,u)
	if v has a right child w in T then
		preorder(T,w)
```

 

[![2023-03-13-08-22-06.png](https://i.postimg.cc/JnTSbMkW/2023-03-13-08-22-06.png)](https://postimg.cc/62vHKscH)

### Inorder Traversal

only makes sense for binary trees （只对二叉树）

先左，再自己，后右

```
Algorithm inorder(T,v):
	if v has a left child u in T then
		inorder(T,u)
	perform the "visit" action for node v
	if v has a right child w in T then
		inorder(T,w)
```

[![2023-03-13-08-28-29.png](https://i.postimg.cc/j5m0pRd4/2023-03-13-08-28-29.png)](https://postimg.cc/62rmRJZ8)

### Postorder Traversal

```
def postorder(T, v):
	if v has a left child u in T, then
		postorder(T, u)
	if v has a right child w in T, then
		postorder(T, w)
	perform the "visit" action for node v
```



![](https://s3.bmp.ovh/imgs/2023/03/13/38f85520fbc91c86.png)



## AVL Trees

High-balance property: 每个节点的子树的高度之差的绝对值≤1

AVL trees have expected performance O(log n).



### single rotations

### double rotations