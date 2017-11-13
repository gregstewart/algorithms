// @flow

export default class {
  id: Array<number>
  size: Array<number>
  constructor(n: number): void {
    this.id = [];
    this.size = [];
    for(let i = 0; i < n; i++) {
      this.id.push(i);
    }
    for(let i = 0; i < n; i++) {
      this.size.push(1);
    }
  }

  root(i: number): number {
    while(i !== this.id[i]) {
      this.id[i] = this.id[this.id[i]];
      i = this.id[i];
    }

    return i;
  }

  union(p: number, q:number): void {
    const i = this.root(p);
    const j = this.root(q);

    if (this.size[i] < this.size[j]) {
      this.id[i] = j;
      this.size[j] += this.size[i];
    } else {
      this.id[j] = i;
      this.size[i] += this.size[j];
    }
  }

  connected(p: number, q: number): boolean {
    return this.root(p) == this.root(q);
  }
}
