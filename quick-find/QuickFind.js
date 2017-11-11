// @flow

export default class {
  id: Array<number>
  constructor(n: number):void {
    this.id = []
    for(let i = 0; i < n; i++) {
      this.id.push(i);
    }
  }

  union(p: number, q:number):void {
    const pid = this.id[p];
    const qid = this.id[q];

    for(let i = 0; i < this.id.length; i++) {
      if (this.id[i] === pid) {
        this.id[i] = qid;
      }
    }
  }

  connected(p: number, q: number): boolean {
    return this.id[p] === this.id[q];
  }
}
