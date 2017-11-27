// @flow

class Node {
  item: string;
  next: Node | null;
}

export default class {
  first: Node;
  last: Node;

  enqueue(item: string): void {
    const oldlast: Node = this.last;
    this.last = new Node();
    this.last.item = item;
    this.last.next = undefined;

    if(this.isEmpty()) {
      this.first = this.last;
    } else {
      oldlast.next = this.last;
    }
  }

  dequeue(): string {
    const item: string = this.first.item;
    this.first = this.first.next;
    if(this.isEmpty()) {
      this.last = undefined;
    }
    return item;
  }

  isEmpty(): boolean {
    return this.first === undefined;
  }
}
