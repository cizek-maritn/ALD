

from dataclasses import dataclass
from typing import Optional


class Node:
    def __init__(self, value: int):
        self.value = value
        self.left: Node = None
        self.right: Node = None

@dataclass
class Node2:
    value: int
    left: Optional['Node'] = None
    right: Optional['Node'] = None

    class Tree:

        def __init__(self) -> None:
            self.root: Node = None


        def _insert(self, value: int, node: Node):
            if value > node.value:
                if node.right is None:
                    node.right = Node(value)
                    return node.right
                else:
                     return self._insert(value, node.right)
            else:
                if node.left is None:
                    node.left = Node(value)
                    return node.left
                else:
                    return self._insert(value, node.left)

        def insert(self, value: int):
            if self.root is None:
                self.root = Node(value)
                return self.root

            return self._insert(value, self.root)

        def _find(self, value: int, node: Node):
            if value > node.value:
                if node.right is None:
                    return -1
                else:
                     return self._find(value, node.right)
            elif value < node.left:
                if node.left is None:
                    return -1
                else:
                    return self._find(value, node.left)
            else:
                return node

        def find(self, value: int):
            if self.root is None:
                return -2
            else:
                return self._find(value, self.root)

        def inorder(node: Node):
            if node is None: return

            inorder(node.left)
            print(node.value)
            inorder(node.right)

        def preorder(node: Node):
            if node is None: return

            print(node.value)
            preorder(node.left)
            preorder(node.right)

        def preorder(node: Node):
            if node is None: return

            preorder(node.left)
            preorder(node.right)
            print(node.value)

        def traverse(node: Node, method="inorder"):


    tree = Tree()

    tree.insert(4)
    tree.insert(5)
    tree.insert(7)
    tree.insert(3)
    tree.insert(4)
