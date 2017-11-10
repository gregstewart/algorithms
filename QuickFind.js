
export default class {
  constructor(n) {
    this.id = []
    for(let i = 0; i < n; i++) {
      this.id.push(i);
    }
  }

  union(p, q) {
    const pid = this.id[p];
    const qid = this.id[q];

    for(let i = 0; i < this.id.length; i++) {
      if (this.id[i] === pid) {
        this.id[i] = qid;
      }
    }
  }

  connected(p,q) {
    return this.id[p] === this.id[q];
  }
}
