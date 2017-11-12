import WeightedQuickUnion from "./WeightedQuickUnion";

describe("WeightedQuickUnion", () => {
  let weightQuickUnion;
  let n;
  beforeEach(() => {
    n = 10;
    weightQuickUnion = new WeightedQuickUnion(n);
  });

  describe("On init", () => {
    it("has ten components", () => {
      expect(weightQuickUnion.id.length).toBe(n);
    });
    it("each component is independent (i.e. not connected)", () => {
      for(let i = 0; i < n; i++) {
        expect(weightQuickUnion.id[i]).toBe(i);
      }
    });
  });

  describe("Union", () => {
    it("connects a node with it's immediate root", () => {
      weightQuickUnion.union(4,3);

      expect(weightQuickUnion.id[3]).toBe(4);
    });

    it("connects a node with the larger tree root", () => {
      weightQuickUnion.union(4,3);
      weightQuickUnion.union(3,8);

      expect(weightQuickUnion.id[8]).toBe(4);
    });
  });

  describe("Connected", () => {
    it("returns true when two nodes are connected", () => {
      weightQuickUnion.union(4,3);

      expect(weightQuickUnion.connected(4,3)).toBe(true);

      weightQuickUnion.union(3,8);
      expect(weightQuickUnion.connected(4,8)).toBe(true);
    });

    it("returns false when two nodes are connected", () => {
      expect(weightQuickUnion.connected(4,3)).toBe(false);
    });
  });

  describe("Integration", () => {
    it("uses the demo to verify the end state", () => {
      const expected = [6,2,6,4,6,6,6,2,4,4];
      weightQuickUnion.union(4,3);
      weightQuickUnion.union(3,8);
      weightQuickUnion.union(6,5);
      weightQuickUnion.union(9,4);
      weightQuickUnion.union(2,1);
      expect(weightQuickUnion.connected(8,9)).toBe(true);
      expect(weightQuickUnion.connected(5,4)).toBe(false);
      weightQuickUnion.union(5,0);
      weightQuickUnion.union(7,2);
      weightQuickUnion.union(6,1);
      weightQuickUnion.union(7,3);
      expect(weightQuickUnion.id).toEqual(expected);
    });
  });
});
