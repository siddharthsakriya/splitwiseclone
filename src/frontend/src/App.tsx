import { Button } from "@/components/ui/button"

const App = () => {
  const circles = [
    { id: 1, name: "Friends Trip", members: 4 },
    { id: 2, name: "Roommates", members: 3 },
    { id: 3, name: "Family", members: 6 },
    { id: 4, name: "Work Lunch", members: 5 },
  ];

  const handleCircleClick = (circleName: string) => {
    console.log(`Clicked on ${circleName}`);
    // Add your navigation logic here
  };

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Header */}
      <header className="bg-white shadow-sm border-b">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex justify-between items-center py-4">
            <h1 className="text-2xl font-bold text-gray-900">SplitCircles</h1>
            <div className="flex gap-2">
              <Button variant="default">Logout</Button>
              <Button variant="default">Settings</Button>
            </div>
          </div>
        </div>
      </header>

      <div className="flex items-center justify-center sm:px-10 py-20">
        <h1 className="text-2xl font-bold text-gray-900">Choose from one of the Circles below</h1>
      </div>

      {/* Main Content */}
      <main className="max-w-7xl mx-auto py-5 sm:px-6 lg:px-8">
        <div className="px-4 py-6 sm:px-0">
          <div className="border-4 border-gray-200 rounded-lg p-6">
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
              {circles.map((circle) => (
                <div
                  key={circle.id}
                  onClick={() => handleCircleClick(circle.name)}
                  className="bg-white p-6 rounded-lg shadow-md hover:shadow-lg transition-shadow cursor-pointer border hover:border-blue-300"
                >
                  <h3 className="text-lg font-semibold text-gray-900 mb-2">
                    {circle.name}
                  </h3>
                  <p className="text-sm text-gray-600">
                    {circle.members} members
                  </p>
                </div>
              ))}
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;