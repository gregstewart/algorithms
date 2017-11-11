import QuickFind from "./QuickFind";

describe("QuickFind", () => {
  let quickFind;
  let n;
  beforeEach(() => {
    n = 10;
    quickFind = new QuickFind(n);
  });

  describe("On init", () => {
    it("has ten components", () => {
      expect(quickFind.id.length).toBe(n);
    });
    it("each component is independent (i.e. not connected)", () => {
      for(let i = 0; i < n; i++) {
        expect(quickFind.id[i]).toBe(i);
      }
    });
  });

  describe("Union", () => {
    it("connects two nodes in the array", () => {
      quickFind.union(4,3);

      expect(quickFind.id[4]).toBe(3);
    });
  });

  describe("Connected", () => {
    it("returns true when two nodes are connected", () => {
      quickFind.union(4,3);

      expect(quickFind.connected(4,3)).toBe(true);
    });

    it("returns false when two nodes are connected", () => {
      expect(quickFind.connected(4,3)).toBe(false);
    });
  });

  describe("Integration", () => {
    it("verifies the end state", () => {
      quickFind.union(0,5);
      quickFind.union(5,6);
      quickFind.union(6,1);
      quickFind.union(2,1);
      quickFind.union(7,2);
      quickFind.union(3,8);
      quickFind.union(4,3);
      quickFind.union(9,4);

      const expected = [1,1,1,8,8,1,1,1,8,8];

      expect(expected).toEqual(quickFind.id);
    });
  });
});
