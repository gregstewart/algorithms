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
});
