import QuickUnion from "./QuickUnion";

describe("QuickUnion", () => {
  let quickUnion;
  let n;
  beforeEach(() => {
    n = 10;
    quickUnion = new QuickUnion(n);
  });

  describe("On init", () => {
    it("has ten components", () => {
      expect(quickUnion.id.length).toBe(n);
    });
    it("each component is independent (i.e. not connected)", () => {
      for(let i = 0; i < n; i++) {
        expect(quickUnion.id[i]).toBe(i);
      }
    });
  });

  describe("Union", () => {
    it("connects a node with it's immediate root", () => {
      quickUnion.union(4,3);

      expect(quickUnion.id[4]).toBe(3);
    });

    it("connects a node with it's parent's root", () => {
      quickUnion.union(4,3);
      quickUnion.union(7,4);

      expect(quickUnion.id[7]).toBe(3);
    });
  });

  describe("Connected", () => {
    it("returns true when two nodes are connected", () => {
      quickUnion.union(4,3);

      expect(quickUnion.connected(4,3)).toBe(true);
    });

    it("returns false when two nodes are connected", () => {
      expect(quickUnion.connected(4,3)).toBe(false);
    });
  });

  describe("Integration", () => {
    it("uses the demo to verify the end state", () => {
      const expected = [1,8,1,8,3,0,5,1,8,8];
      quickUnion.union(4,3);
      quickUnion.union(3,8);
      quickUnion.union(6,5);
      quickUnion.union(9,4);
      quickUnion.union(2,1);
      expect(quickUnion.connected(8,9)).toBe(true);
      expect(quickUnion.connected(5,4)).toBe(false);
      quickUnion.union(5,0);
      quickUnion.union(7,2);
      quickUnion.union(6,1);
      quickUnion.union(7,3);
      expect(quickUnion.id).toEqual(expected);
    });
  });
});
