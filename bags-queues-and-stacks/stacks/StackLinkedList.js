// @flow

class Node {
  item: string;
  next: Node | null;
}

export default class {
  first: Node;

  push(item: string): void {
    const oldfirst: Node = this.first;
    this.first = new Node();
    this.first.item = item;
    this.first.next = oldfirst;
  }

  pop(): string {
    const item: string = this.first.item;
    console.log(this.first.next);
    this.first = this.first.next;
    return item;
  }

  isEmpty(): boolean {
    return this.first === undefined;
  }
}
