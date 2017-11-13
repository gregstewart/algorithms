// @flow

export default class {
  id: Array<number>
  constructor(n: number): void {
    this.id = []
    for(let i = 0; i < n; i++) {
      this.id.push(i);
    }
  }

  root(i: number): number {
    while(i !== this.id[i]) {
      i = this.id[i];
    }

    return i;
  }

  union(p: number, q:number): void {
    const i = this.root(p);
    const j = this.root(q);

    this.id[i] = j;
  }
  
  connected(p: number, q: number): boolean {
    return this.root(p) == this.root(q);
  }
}
