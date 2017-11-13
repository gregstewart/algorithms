import WeightedQuickUnionWithPathCompression from "./WeightedQuickUnionWithPathCompression";

describe("WeightedQuickUnionWithPathCompression", () => {
  let weightQuickUnionWithPathCompression;
  let n;
  beforeEach(() => {
    n = 10;
    weightQuickUnionWithPathCompression = new WeightedQuickUnionWithPathCompression(n);
  });

  describe("On init", () => {
    it("has ten components", () => {
      expect(weightQuickUnionWithPathCompression.id.length).toBe(n);
    });
    it("each component is independent (i.e. not connected)", () => {
      for(let i = 0; i < n; i++) {
        expect(weightQuickUnionWithPathCompression.id[i]).toBe(i);
      }
    });
  });

  describe("Union", () => {
    it("connects a node with it's immediate root", () => {
      weightQuickUnionWithPathCompression.union(4,3);

      expect(weightQuickUnionWithPathCompression.id[3]).toBe(4);
    });

    it("connects a node with the larger tree root", () => {
      weightQuickUnionWithPathCompression.union(4,3);
      weightQuickUnionWithPathCompression.union(3,8);

      expect(weightQuickUnionWithPathCompression.id[8]).toBe(4);
    });

    it("compresses the path", () => {
      //expected tree after a bunch of commands
      weightQuickUnionWithPathCompression.id = [0,0,0,1,1,1,3,7,8,9];
      weightQuickUnionWithPathCompression.union(6,9);

      expect(weightQuickUnionWithPathCompression.id[9]).toBe(0);
    });
  });

  describe("Connected", () => {
    it("returns true when two nodes are connected", () => {
      weightQuickUnionWithPathCompression.union(4,3);

      expect(weightQuickUnionWithPathCompression.connected(4,3)).toBe(true);

      weightQuickUnionWithPathCompression.union(3,8);
      expect(weightQuickUnionWithPathCompression.connected(4,8)).toBe(true);
    });

    it("returns false when two nodes are connected", () => {
      expect(weightQuickUnionWithPathCompression.connected(4,3)).toBe(false);
    });
  });

  describe("Integration", () => {
    it("uses the demo to verify the end state", () => {
      const expected = [6,2,6,4,6,6,6,6,4,4];
      weightQuickUnionWithPathCompression.union(4,3);
      weightQuickUnionWithPathCompression.union(3,8);
      weightQuickUnionWithPathCompression.union(6,5);
      weightQuickUnionWithPathCompression.union(9,4);
      weightQuickUnionWithPathCompression.union(2,1);
      expect(weightQuickUnionWithPathCompression.connected(8,9)).toBe(true);
      expect(weightQuickUnionWithPathCompression.connected(5,4)).toBe(false);
      weightQuickUnionWithPathCompression.union(5,0);
      weightQuickUnionWithPathCompression.union(7,2);
      weightQuickUnionWithPathCompression.union(6,1);
      weightQuickUnionWithPathCompression.union(7,3);
      expect(weightQuickUnionWithPathCompression.id).toEqual(expected);
    });
  });
});
