// @flow
// this is not needed in JS, but I am just experimenting with
// Java implementations of algorithms

export default class {
  s: Array<string|void>;
  N: number;

  constructor() {
    this.s = [];
    this.s.length = 1;
    this.N = 0;
  }

  push(item: string): void {
    if(this.N === this.s.length) {
      this.resize(2 * this.s.length);
    }
    this.s[this.N++] = item;
  }

  pop(): string | void {
    const item: string |void = this.s[--this.N];
    this.s[this.N] = undefined;
    if(this.N > 0 && this.N === this.s.length/4) {
      this.resize(this.s.length/2);
    }
    return item;
  }

  isEmpty(): boolean {
    return this.N === 0;
  }

  resize(capacity: number): void {
    let copy: Array<string | void> = [];
    copy.length = capacity;
    for (let i: number = 0; i < this.N; i++) {
      copy[i] = this.s[i];
    }

    this.s = copy;
  }
}
